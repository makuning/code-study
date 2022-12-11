const fs = require('fs');

fs.readFile('./files/test.txt','utf8',function(err,rep) {
    if (err) {
        return console.log('读取失败\n' + err);
    }
    return console.log(rep);
});