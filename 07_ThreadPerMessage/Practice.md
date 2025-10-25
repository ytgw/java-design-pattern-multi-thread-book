# 7章 練習問題
不正解と書かれている問題は間違った問題で、何も書かれていない問題は正解した。

## 問題1
1. o
2. x
3. x
4. x
5. x


## 問題2
省略。


## 問題3
startメソッドでなくrunメソッドを使っているのでスレッドが起動しない。
そのため、マルチスレッドで実行されずhandleメソッドが一つずつ実行される。


## 問題4
省略。


## 問題5
省略。


## 問題6
(不正解)
MiniServer.execute内のローカル変数cilentSocketにfinalをつけるべきだった。
ただし、新しいバージョンのJavaでは、明示的に付けなくても、一度初期化された後に値が変更されないローカル変数は実質的なfinalとして扱われるとのこと。


## 問題7
(不正解)
スレッドを切り替えるためにスリープしていたが切り替わる保証がないので。


## 問題8
以下が表示される。
```txt
MainThread:main:BEGIN
MainThread:execute:BEGIN
MainThread:newThread:BEGIN
MainThread:newThread:END
MainThread:execute:END
MainThread:main:END
QuizThread:run:BEGIN
QuizThread:Hello!
QuizThread:run:END
```
