const fs = require('fs');

fs.writeFile('./files/test.txt','That is so good!','utf8',function(err,rep) {
    if (err) {
        return console.log('写入失败！\n');
    }
    return console.log('写入成功！');
})