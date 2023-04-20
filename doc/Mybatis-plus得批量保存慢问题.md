## Mybatis-plus得批量保存慢问题

### 先使用saveOrUpdateBatch 进行批量保存更新，60条数据耗时8秒左右

### 将列表区分为save和update两个list分别执行updateBatchById和saveBatch 批量操作后 60条数据耗时3秒左右

### 给mysql得url  jdbc:mysql:...&allowMultiQueries=true&rewriteBatchedStatements=true 进行拼接后 批量操作后 60条数据耗时1秒左右