## 网址：
https://dev.mysql.com/doc/refman/5.7/en/json-modification-functions.html

## MySQL对JSON的操作语法：
1. JSON_VALUE：用于从JSON文档中提取特定键的值。语法如下：
   JSON_VALUE(json_doc, path)
   其中，json_doc是包含JSON数据的列或表达式，path是要提取的键的路径。

2. JSON_UNQUOTE：用于删除JSON值的引号。语法如下：
   JSON_UNQUOTE(json_val)
   其中，json_val是要删除引号的JSON值。

3. JSON_EXTRACT：用于提取JSON文档中的特定数据。语法如下：
   JSON_EXTRACT(json_doc, path)
   其中，json_doc是包含JSON数据的列或表达式，path是要提取的数据的路径。

4. JSON_SET：用于在JSON文档中设置新的键值对。语法如下：
   JSON_SET(json_doc, path, value)
   其中，json_doc是包含JSON数据的列或表达式，path是要设置的键的路径，value是要设置的值。

5. JSON_REMOVE() 删除 JSON 元素
    UPDATE lnmp SET category = JSON_REMOVE(category, '$.url', '$.host') WHERE id = 1;

6. JSON_REPLACE() 只替换存在的值
  UPDATE lnmp SET category = JSON_REPLACE(category, '$.name', 'php', '$.url', 'http://www.php.net') WHERE id = 2;

7. JSON_INSERT() 插入新值，但不会覆盖已经存在的值
    UPDATE lnmp SET category = JSON_INSERT(category, '$.name', 'lnmp', '$.url', 'www.lnmp.cn') WHERE id = 1;
8. *column->path *
    SELECT id, category->'$.name', JSON_UNQUOTE(category->'$.name'), category->>'$.name' FROM lnmp;



