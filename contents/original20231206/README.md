# 共有会 2023/12/06
## 問題
`/hello` および `/goodbye` の2つのパスにアクセスされた際に、レスポンスコードが `200 OK` で以下の JSON を返すサーバーを実装せよ。

`/hello` の場合
```json
{
  "Message": "Hello !!!"
}
```
`/goodbye` の場合
```json
{
  "Message": "Goodbye !!!"
}
```

ただし、`/hello` および `/goodbye` の2つのパス以外にアクセスされた際は、レスポンスコードが `400 Bad Request` で以下の JSON を返す。
```json
{
  "Message": "Error !!!"
}
```

テストも実装せよ。
