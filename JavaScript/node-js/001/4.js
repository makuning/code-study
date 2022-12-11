const fs = require('fs');
const path = require('path');

const pathStr = path.join(__dirname,'./files/test.txt');

fs.readFile(pathStr,'utf8',function(err,data) {
    if (err) {
        return console.log('读取失败\n' + err);
    }
    console.log(path.dirname(pathStr));
    console.log(path.basename(pathStr));
    console.log(path.extname(pathStr));

    return console.log(data);
});
