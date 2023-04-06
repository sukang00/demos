## 修改git历史提交记录的用户名和邮箱
1. 在所在项目内打开git bash
2. 拉取最新代码
3. 输入下面内容
git filter-branch -f --env-filter '
OLD_EMAIL="旧邮箱"
CORRECT_NAME="新用户名"
CORRECT_EMAIL="新邮箱"
if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_AUTHOR_NAME="$CORRECT_NAME"
    export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags
4. 强制推送
git push origin main -f

## 修改git当前项目的用户名和邮箱
git config user.name "新用户名"
git config user.email "新邮箱"


## 删除git本地分支
git branch -D master 