# 2章 練習問題
不正解と書かれている問題は間違った問題で、何も書かれていない問題は正解した。

## 問題1
1. o
2. x
3. o
4. x
5. x


## 問題2
replaceメソッドは置換後の文字列を返すが、引数に渡したStringを変更はしていないので、StringはImmutableである。


## 問題3
省略。


## 問題4
getInfoメソッドで取得したmutableな変数を使って変更できるため。


## 問題5
mutableである。
Pointを引数にしたコンストラクタで生成した場合、コンストラクタ後にそのPointを使って変更できるから。


## 問題6
(不正解)getNameとsetPersonを同時に実行できる箇所が問題がある。

(正解)ImmutablePersonのMutablePerson型のpersonを引数にしたコンストラクタ内で、引数personに対してsynchronizedブロックを使うべき。
