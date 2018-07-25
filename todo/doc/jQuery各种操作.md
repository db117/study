####jquery 获取div宽度
```
var content = $(‘div’). width();//只是获取content宽度

var contentWithPadding = $(‘div’). innerWidth();//获取content+padding的宽度

var withoutMargin = $(‘div’). outerWidth();//获取content+padding+border的宽度

var full = $(‘div’). outerWidth(true);//获取content+padding+border+margin的宽度
```