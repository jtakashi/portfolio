概要
仮想マシンにWebアプリ実行環境を作るまで

構築した環境
仮想マシン：AWS EC2 ,VirtualBox (後者は若干手順が多い）
OS：CentOS　7
ミドルウェア：Apatche2.4, Apatch Tomcat9, MySQL 8
ランタイム環境：Open-jdk-1.8.0

使用するPC：Windows、Mac　の両方。(どちらでもできる)
ターミナルソフト：Tera Term(Windows), Terminal(Mac標準のもの)

事前準備
AWS  :  OSを選択しインスタンスとssh認証カギを作成しターミナルソフトで接続テスト
VBox :  OS入れてネットワーク設定をブリッヂアダプターあるいは、NAT＆ホストオンリーアダプタ―で設定。

やったこと
Tomcatの導入
１　wgetコマンドのインストール
２　jdkのインストール
３　tomcatのtarファイルをwgetでダウンロード&解凍
４　Unitファイルの作成
５　AJPコネクターの設定
６　ファイヤウォールの設定(VBoxのみ)
７　Selinuxの設定をして8080ポートで接続確認
完成

Apatchの導入&Tomcatとの接続
１　Apatche(httpd)をyumでインストール
２　tomcatコネクターをwget
３　yum インストール httpd-devel、gcc
４　mod_jkをmakefileでインストール
５　mod_jkモジュールを設定
６　ipv6の設定をoff 
７　ブラウザで80ポートに接続確認(Tomcatの管理画面が表示されていること）
完成

MySQLの導入(これは簡単）
１　Tomcat用環境変数の登録
２　MySQL用リポジトリインストール
３　MySQLインストール・起動確認
４　JDBCドライバ導入
完成

参考にさせていただいた動画
https://www.youtube.com/watch?v=kxjrd2faZMM&list=PLKOzQ37Ax2sQvwtgk2J0K1_U8-P2A5Qd3&index=4
https://www.youtube.com/watch?v=jtOlNtVF468&list=PLKOzQ37Ax2sQvwtgk2J0K1_U8-P2A5Qd3&index=8
