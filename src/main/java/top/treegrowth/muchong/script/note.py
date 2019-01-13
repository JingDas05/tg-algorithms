# #!/usr/bin/env python
# # -*- encoding: utf-8 -*-
# # Created on 2018-05-06 08:44:11
# # Project: muchong_note_detail
#
# from pyspider.libs.base_handler import *
# import hashlib
# import re
# from pyspider import database
# import mysql.connector
# from datetime import date, datetime, timedelta
# #import redis
#
# class Handler(BaseHandler):
#     crawl_config = {
#     }
#
#     note_insert = ("INSERT INTO note (id, target_id, building_id, title, content, floor, device, first_category_name, second_category_name, third_category_name, author_id,  create_time) VALUES (%(id)s, %(target_id)s, %(building_id)s, %(title)s, %(content)s, %(floor)s, %(device)s, %(first_category_name)s, %(second_category_name)s, %(third_category_name)s, %(author_id)s, %(create_time)s)")
#
#     note_update = ("UPDATE note SET id = %(id)s, target_id = %(target_id)s, building_id = %(building_id)s, title = %(title)s, content = %(content)s, floor = %(floor)s, device = %(device)s, first_category_name = %(first_category_name)s, second_category_name = %(second_category_name)s, third_category_name =  %(third_category_name)s, author_id =  %(author_id)s,  create_time = %(create_time)s WHERE id= %(id)s")
#
#     note_projectdb = database.connect_database('elasticsearch+projectdb://127.0.0.1:9200/?index=note')
#     conn = mysql.connector.connect(user='root', password='0109)!)(QWe',host="127.0.0.1", port="3306", database='spider', autocommit=True)
#     cursor = conn.cursor()
#     #redis = redis.StrictRedis(host='127.0.0.1', port=6379, db=0)
#
#     def _insert(self, note_values):
#         self.cursor.execute(self.note_insert, note_values)
#     def _update(self, note_values):
#         self.cursor.execute(self.note_update, note_values)
#
#
#         # 处理帖子内容的方法，获取 回帖target_id, 帖子内容，发帖客户端
#     def handle_content(self, content_area, building_id):
#         hl_md5 = hashlib.md5()
#         # 原生帖子内容, eg: 引用回帖:4楼:Originallypostedby含笑木香at2018-04-0321:08:49比如我，最喜欢暴风雨的时候睡懒觉，
#         # 我也很喜欢啊，别人怕暴风雨，我是遇到暴风雨就兴奋发自小木虫IOS客户端
#         raw_content = content_area("div[class='t_fsz']").find("td:eq(0)").text().replace("\n", "").replace(" ", "")
#         if (raw_content == ""):
#             target_id = ""
#             content = ""
#             device = ""
#             return target_id, content, device
#         else:
#             # 处理有引用回帖的情况
#             if raw_content.startswith("引用回帖"):
#                 # 获取引用回帖的中的日期
#                 maybe_date = re.search(r"(\d{4}-\d{1,2}-\d{1,2}\d{1,2}:\d{1,2}:\d{1,2})", raw_content)
#                 if not maybe_date:
#                     target_id = ""
#                     content = ""
#                     device = ""
#                     return target_id, content, device
#                 founded_date = maybe_date.group(0)
#                 # 对于引用回帖的内容进行截取，key1=引用回帖: key2=at
#                 reference_str = raw_content[raw_content.find("引用回帖:") + 5:raw_content.find(founded_date) - 2]
#                 print(reference_str)
#                 # 获取虫名 以及 楼层，还有上面的日期，拼接raw_id
#                 raw_id = reference_str[reference_str.find("Originallypostedby") + 18:] + founded_date + reference_str[:reference_str.find("楼")]
#                 print("target_id"+raw_id)
#                 hl_md5.update(raw_id.replace(" ", "").encode(encoding='utf-8'))
#                 target_id = hl_md5.hexdigest()
#                 # 获取帖子内容
#                 content = raw_content[raw_content.find(founded_date) + 18:raw_content.find("发自小木虫")]
#                 # 获取客户端
#                 if raw_content.find("发自小木虫") != -1:
#                     device = raw_content[raw_content.find("发自小木虫") + 5:raw_content.find("客户端")]
#                 else:
#                     device = "PC"
#                 return target_id, content, device
#             else:
#                 target_id = building_id
#                 content = raw_content[:raw_content.find("发自小木虫")]
#                 if raw_content.find("发自小木虫") != -1:
#                     device = raw_content[raw_content.find("发自小木虫") + 5:raw_content.find("客户端")]
#                 else:
#                     device = "PC"
#                 return target_id, content, device
#
#
#     @every(minutes=1)
#     def on_start(self):
#         self.crawl('http://muchong.com/t-12277864-2', callback=self.handle_note, cookies={
#             "Hm_lpvt_2207ecfb7b2633a3bc5c4968feb58569": "1547264322",
#             "Hm_lvt_2207ecfb7b2633a3bc5c4968feb58569": "1547264296",
#             "_emuch_index":"1",
#             "_discuz_pw":"50c5bc964f196048",
#             "_discuz_uid": "8660526",
#             "_ga": "GA1.2.690986424.1547264296",
#             "_gat": "1",
#             "discuz_tpl":"qing"
#         })
#
#     @config(age=1)
#     def handle_note(self, response):
#         request_url = response.url
#         building_id = request_url[request_url.rfind("/") + 1:request_url.rfind("-") + 1]
#         page_sign = request_url[request_url.rfind("-") + 1:]
#         # 获取整个doc
#         context = response.doc
#         print(context)
#         for each_note in context("tbody[id^='pid']").items():
#             # 这个md5对象，需要每次都新生成，否则生成的md5值会有问题
#             hl_md5 = hashlib.md5()
#             note = {}
#             author = each_note.find("div.pls_user h3 a")
#             # 作者链接
#             author_link = author.attr("href")
#             note["author_id"] = author_link[author_link.find("uid=") + 4:]
#             author_actual_link = author_link.replace("muchong.com", "muchong.com/bbs")
#             # 楼层及创建时间块
#             floor_time_area = each_note.find("div[class='pls_info']")
#             create_time = floor_time_area("em").text()
#             note["create_time"] = create_time
#             # 一楼是1楼，二楼是沙发，三楼是板凳，四楼是4楼
#             raw_floor = floor_time_area("span a").text()
#             floor = "2楼" if raw_floor == "沙发" else ("3楼" if raw_floor == "板凳" else raw_floor)
#             note["floor"] = floor[:-1]
#             raw_id = author.text() + create_time + floor[:-1]
#             print("id"+ raw_id)
#             hl_md5.update(raw_id.replace(" ", "").encode(encoding='utf-8'))
#             note["id"] = hl_md5.hexdigest()
#             # 帖子内容区域
#             content_area = each_note.find("td[class='plc_mind'] div[class='plc_Con']")
#             # 赋值全局变量楼主帖子id
#             if note["floor"] == "1":
#                 note["title"] = content_area("h1").text()
#                 # 如果是帖子的第一页,第一楼为全局id
#                 if int(page_sign) == 1:
#                     note["id"] = building_id
#             else:
#                 note["title"]=""
#             if content_area:
#                 target_id, content, device = self.handle_content(content_area, building_id)
#                 note["target_id"] = target_id
#                 note["content"] = content
#                 note["device"] = device
#             category_names = context.find("span.breadcrumb")
#             # 一级分类名称
#             note["first_category_name"] = category_names("a:eq(1)").text()
#             # 二级分类名称
#             note["second_category_name"] = category_names("a:eq(2)").text()
#             # 三级分类名称
#             note["third_category_name"] = category_names("a:eq(3)").text()
#             note["building_id"] = building_id
#             #print(self.redis.sadd("note", note["id"]))
#             self.note_projectdb.es.index("note", "project", note, note["id"])
#             # 插入mysql
#             print(note)
#             # note["create_time"] = date(2018, 6, 14)
#             try:
#                 self._insert(note)
#             except BaseException:
#                 note["content"] = note["content"]
#                 self._update(note)
#                 print("mysql 已有记录,进行更新")
#
#
#
#
