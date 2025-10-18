# 3章 練習問題
不正解と書かれている問題は間違った問題で、何も書かれていない問題は正解した。

## 問題1
1. o
2. x
3. o
4. o
5. x
6. x
7. x


## 問題2
安全に動作する。
synchronizedメソッドのため、getRequestとputRequestは同時に複数のスレッドから実行できないため。


## 問題3
(不正解)
期待通りに呼び出されているとは、具体的に何を意味しているかわからない。
仮にwaitメソッド実行後はnotifyAllが実行されるまで待機されることを期待していたとして、どのようなデバッグプリントを入れればそれが検証できるかわからなかった。


## 問題4
1. waitがタイムアウト等をした場合に、queue.remove()実行時にNullを取得してしまう可能性がある(安全性が悪化する)。

2. getRequestを複数スレッドから呼び出した場合に、queue.remove()実行時にNullを取得してしまう可能性がある(安全性が悪化する)。

3. InterruptedExceptionが発生した場合に、queue.remove()実行時にNullを取得してしまう可能性がある(安全性が悪化する)。

4. synchronizedなgetRequestが終了せずputRequestが実行できなくなる(生存性が悪化する)。


## 問題5
TalkThread同士が相手からのリクエストをもらうまで待機しているから。


## 問題6
(不正解)RequestQueue.getRequest内のwait時にInterruptedExceptionが発生するとスレッドの中断ステータスはクリアされ、スレッド全体が終了しないから。
