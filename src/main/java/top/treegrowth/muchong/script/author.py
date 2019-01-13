# #!/usr/bin/env python
# # -*- encoding: utf-8 -*-
# # Created on 2018-04-03 20:28:16
# # Project: root_spider
#
# from pyspider.libs.base_handler import *
# import hashlib
# import re
# from pyspider import database
# import mysql.connector
# from datetime import date, datetime, timedelta
#
# class Handler(BaseHandler):
#
#     def _is_number(self, s):
#         try:
#             float(s)
#             return True
#         except ValueError:
#             pass
#
#         try:
#             import unicodedata
#             unicodedata.numeric(s)
#             return True
#         except (TypeError, ValueError):
#             pass
#
#         return False
#
#     author_set = set()
#
#     crawl_config = {
#     }
#
#     author_projectdb = database.connect_database('elasticsearch+projectdb://127.0.0.1:9200/?index=author')
#     flower_projectdb = database.connect_database('elasticsearch+projectdb://127.0.0.1:9200/?index=flower')
#
#     author_insert = ("INSERT INTO author (id, register_time, name, sex, birthday_time, coin_num, major, help_num, grant_num, fans_num, flower_num, note_num) VALUES (%(id)s, %(register_time)s, %(name)s, %(sex)s, %(birthday_time)s, %(coin_num)s, %(major)s, %(help_num)s, %(grant_num)s, %(fans_num)s, %(flower_num)s, %(note_num)s)")
#     author_update = ("UPDATE note SET id = %(id)s, register_time = %(register_time)s, name = %(name)s, sex = %(sex)s, birthday_time = %(birthday_time)s, coin_num = %(coin_num)s, major = %(major)s, help_num = %(help_num)s, grant_num = %(grant_num)s, fans_num =  %(fans_num)s, flower_num =  %(flower_num)s,  note_num = %(note_num)s WHERE id= %(id)s")
#
#     flower_insert = ("INSERT INTO flower (owner_id, sender_name, owner_name, flower_num) VALUES (%(owner_id)s, %(sender_name)s, %(owner_name)s, %(flower_num)s")
#     flowr_update = ("UPDATE flower SET owner_id = %(owner_id)s, sender_name = %(sender_name)s, owner_name = %(owner_name)s, flower_num = %(flower_num)s")
#
#     conn = mysql.connector.connect(user='root', password='0109)!)(QWe',host="127.0.0.1", port="3306", database='spider', autocommit=True)
#     cursor = conn.cursor()
#
#     def _insert_author(self, author_values):
#         self.cursor.execute(self.author_insert, author_values)
#     def _update_author(self, author_values):
#         self.cursor.execute(self.author_update, author_values)
#
#     def _insert_flower(self, flower_insert):
#         self.cursor.execute(self.author_insert, flower_values)
#     def _update_flower(self, flowr_update):
#         self.cursor.execute(self.author_update, flower_values)
#
#
#
#     @every(minutes=1)
#     def on_start(self):
#         self.crawl('http://muchong.com/bbs/space.php?uid=1075017', callback=self.handle_author, cookies={
#             "Hm_lpvt_2207ecfb7b2633a3bc5c4968feb58569": "1547302770",
#             "Hm_lvt_2207ecfb7b2633a3bc5c4968feb58569": "1547302729",
#             "_emuch_index":"1",
#             "_discuz_pw":"4d16d5d80003b55f",
#             "_discuz_uid": "8660679",
#             "_ga": "GA1.2.1350039567.1547302729",
#             "_gat": "1",
#             "discuz_tpl":"qing"
#         })
#
#     @config(age=1)
#     def handle_author(self, response):
#         try:
#             hl_md5 = hashlib.md5()
#             # 作者信息字典
#             author = {}
#             # 获取整个doc
#             context = response.doc
#             # 查找基本信息，class 是userinfo base的table
#             basic_information = context("table.userinfo.base")
#             # 注册时间
#             register_time = basic_information("td:eq(0)").text()
#             if register_time:
#                 author["register_time"] = register_time
#             # 其他基本信息(有三个class 为userinfo的table, 选取第二个)
#             basic_information = context("table.userinfo:eq(1)")
#             author["id"] = basic_information("tr:eq(0) td:eq(0)").text()
#             self.author_set.add(author["id"])
#             print(not author["id"] in self.author_set)
#             author["name"] = context("div.space_index").find("a:eq(0)").text()
#             author["sex"] = basic_information("tr:eq(4) td:eq(0)").text()
#             birthday_time = basic_information("tr:eq(4) td:eq(2)").text()
#             if (not birthday_time == "0000-00-00") and (not birthday_time == ""):
#                 author["birthday_time"] = birthday_time
#             else:
#                 author["birthday_time"] = "2000-01-01 00:00:00"
#             author["coin_num"] = basic_information("tr:eq(1) td:eq(1)").text()
#             author["major"] = basic_information("tr:eq(3) td:eq(2)").text()
#             author["help_num"] = basic_information("tr:eq(0) td:eq(2)").text()
#             author["grant_num"] = basic_information("tr:eq(1) td:eq(2)").text()
#             note_num_src = basic_information("tr:eq(2) td:eq(1)").text()
#             note_num_desc = basic_information("tr:eq(2) td:eq(1) font").text()
#             author["note_num"] = note_num_src.replace(note_num_desc, "").replace("\n","").replace(" ", "")
#             hl_md5.update(author["id"].encode(encoding='utf-8'))
#             es_author_id = hl_md5.hexdigest()
#             composite_info = context("div.space_index table tr").find("div:last").text()
#             #composite_info = context("div.space_index table tr").find("div:eq(-2)").text()
#             print(composite_info)
#             # 截取,切片字符串
#             composite_info = composite_info[composite_info.find("听众"):].split("\xa0")
#             print(composite_info)
#             # 分组存储
#             try:
#                 if len(composite_info) > 0 and not composite_info[0] == "":
#                     author["fans_num"] = composite_info[0][composite_info[0].find(":")+1:].replace(" ", "")
#                     if not self._is_number(author["fans_num"]):
#                         author["fans_num"] = -1
#                     print(author["fans_num"])
#
#                 if len(composite_info) > 1 and not composite_info[1] == "":
#                     author["flower_num"] = composite_info[1][composite_info[1].find(":")+1:].replace(" ","")
#                     if not self._is_number(author["flower_num"]):
#                         author["flower_num"] = -1
#                     print(author["flower_num"])
#             except Exception as e:
#                 print("flower exception"+e)
#
#                 # 查看获取的红花
#                 #try:
#                 #   flowers = context("table.userinfo:eq(2)").find("table")("tr td")
#                 #  flower_num = 0
#                 # for flower_row in flowers.items():
#                 #    hl_md5_flower = hashlib.md5()
#                 #   flower = {}
#                 #   flower["owner_id"] = author["id"]
#                 #   flower["owner_name"] = author["name"]
#                 #   flower["sender_name"] = flower_row("a").text()
#                 #   flower_num = flower_row("font").text()[1:-1]
#                 #   flower["flower_num"] = "1" if flower_num=="" else flower_num
#                 #   raw_index_id = flower["owner_id"]+flower["sender_name"]
#                 #   hl_md5_flower.update(raw_index_id.encode(encoding='utf-8'))
#                 #   flower_es_id = hl_md5_flower.hexdigest()
#                 #   flower_num = flower_num+ int(flower["flower_num"])
#                 #   print(flower_es_id)
#                 #   print(flower)
#                 #   self.flower_projectdb.es.index("flower", "project", flower, flower_es_id)
#                 # 插入mysql
#                 #   try:
#                 #       self._insert_flower(author)
#                 #   except BaseException:
#                 #       self._update_flower(author)
#                 #   print("mysql 已有flower,进行更新")
#                 #author["flower_num"] = flower_num
#                 #expect Exception as e:
#                 #   print("flowers exception"+e)
#             print(author)
#             self.author_projectdb.es.index("author", "project", author, es_author_id)
#             # 插入mysql
#             try:
#                 self._insert_author(author)
#             except Exception as e:
#                 self._update_author(author)
#                 print("mysql 已有author,进行更新"+e)
#
#         except Exception as e:
#             print("author exception"+e)
#
#
#