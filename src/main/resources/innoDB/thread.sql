SHOW VARIABLES LIKE 'innodb_version';
SHOW VARIABLES LIKE 'innodb_%io_threads';
SHOW ENGINE INNODB STATUS;
# 查看缓冲池大小
SHOW VARIABLES LIKE 'innodb_buffer_pool_size';
# 查看缓冲池实例数
SHOW VARIABLES LIKE 'innodb_buffer_pool_instances';
#
SHOW VARIABLES LIKE 'innodb_old_blocks_pct';