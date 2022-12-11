const fs = require('fs');
const path = require('path');

fs.readFile(path.join(__dirname,'./files/index.html'),'utf8',function(err,data) {
    if (err) {
        return console.log('读取文件失败' + err.message);
    }

    console.log('读取文件成功');
    
    const resolveCss = /<style>[\s\S]*<\/style>/;
    const resolveJs = /<script>[\s\S]*<\/script>/;

    generateCss(resolveCss.exec(data)[0]);
    generateJs(resolveJs.exec(data)[0]);

    generateHtml(data,resolveCss,resolveJs);
});

function generateHtml(html,resolveCss,resolveJs) {
    var htmlStr = html.replace(resolveCss,'<link rel="stylesheet" href="./style.css"/>')
    .replace(resolveJs,'<script src="./script.js"></script>');

    fs.writeFile(path.join(__dirname,'./files/html.html'),htmlStr,'utf8',function(err) {
        if (err) {
            return console.log('写入文件成功！');
        }
        return console.log('写入文件失败！');
    });
}

function generateCss(css) {
    var cssStr = css.replace('<style>','')
    .replace('</style>','');

    fs.writeFile(path.join(__dirname,'./files/style.css'),cssStr,'utf8',function(err) {
        if (err) {
            return console.log('写入文件失败！');
        }
        return console.log('写入文件成功！');
    });
}

function generateJs(js) {
    var jsStr = js.replace('<script>','')
    .replace('</script>','');

    fs.writeFile(path.join(__dirname,'./files/script.js'),jsStr,'utf8',function(err) {
        if (err) {
            return console.log('写入文件失败！');
        }
        return console.log('写入文件成功！');
    });
}