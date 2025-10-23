FROM eclipse-temurin:latest

RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y \
    git sudo bash-completion \
    # 7章の練習問題で作成するGUIアプリに必要
    libxi6 libxrender1 libxtst6 \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# ubuntu24ではuid=1000のubuntuというユーザーがデフォルトで存在する。
# 追加するユーザとUIDが重複するときの条件分岐を避けるため削除する。
RUN userdel -r ubuntu
ARG USERNAME='user'
ARG UID=1002

# useraddのmオプションはホームディレクトリ作成のため。
# VSCode周りのファイルはホームディレクトリ以下に作成されるのでmオプションが必要。
RUN useradd -u ${UID} --shell /bin/bash -m ${USERNAME}
RUN echo "${USERNAME} ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers
USER ${USERNAME}
