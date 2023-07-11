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

# fork github的开源代码到gitee上实现加速下载

## 指定fork 的上游仓库
git remote add upstream <github地址>

## 验证
git remote -v

## 获取原仓库的更新,fetch后会存储在本地分支upstream/master上
git fetch upstream

## 合并到本地分支，切换到本地master,合并pstream/master分支
git merge upstream/master

## 推送远程分支
git push origin master

## 添加github
### 1. 生成ssh key
ssh-keygen -t rsa -C 'XX@XX.com'
### 2. id_rsa.pub 复制内容
### 3. github的Settings添加ssh key，把刚才复制的内容粘贴上去保存即可
### 4. 验证是否设置成功
ssh -T git@github.com

### 5. 如果弹出
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes

## git 项目报错 filename too long
git config --system core.longpaths true
