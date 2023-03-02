## ruoyi数据权限扩展

在使用ruoyi框架自带数据权限是根据角色配置的数据权限，分为：
1. 全部数据权限
2. 自定数据权限（角色和部门关联实现）
3. 本部门数据权限
4. 本部门及以下数据权限
5. 仅本人数据权限

具体实现思路
1. 使用注解@DataScope(deptAlias = "d") 来拦截，
```
@DataScope(deptAlias = "d")
public List<...> select(...)
{
    return mapper.select(...);
}
```
2. 在mybatis查询底部标签添加数据范围过滤 
```
<select id="select" parameterType="..." resultMap="...Result">
    <include refid="select...Vo"/>
    <!-- 数据范围过滤 -->
    ${params.dataScope}
</select>
```
给执行sql添加权限过滤语句，

## 问题
1. 角色对应的数据权限设置后，其实是全局的，而默认的是全部数据权限，这样就导致 在一个人有多个角色的时候数据权限控制不了
2. 需要控制数据权限，需要在sql后面关联sys_user和sys_dept表，增加了多表关联，但此问题还是可以接受

### 解决此问题，我的做法

#### 1. 在用户表添加一个数据权限生效的角色id
```
ALTER table sys_user add COLUMN `effective_data_role_id` bigint(20) DEFAULT NULL COMMENT '生效数据权限的角色id';
```
#### 2. 在页面保存用户时候页面选择生效角色保存到数据库
注意：添加字段后要修改SysUserMapper.xml文件，修改/添加/查询语句添加上面的字段

#### 3. 在DataScopeAspect拦截处判断生效角色
```
com.***.framework.aspectj.DataScopeAspect#dataScopeFilter

 public static void dataScopeFilter(JoinPoint joinPoint, SysUser user, String deptAlias, String userAlias)
    {
        StringBuilder sqlString = new StringBuilder();

        for (SysRole role : user.getRoles())
        {
            if (Objects.nonNull(user.getEffectiveDataRoleId()) && !role.getRoleId().equals(user.getEffectiveDataRoleId())){
                continue;
            }
            ...
```

