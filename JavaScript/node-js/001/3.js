const fs = require('fs');

// 读取文件
fs.readFile('./files/grade.txt','utf8',function(err,data) {
    if (err) {
        return console.log('读取失败！' + err);
    }
    
    // 读取成功
    //console.log(data);
    
    // 将字符串转为数组
    const gradeArr = data.split(' ');
    // console.log(gradeArr);

    // 创建数组
    const gradeArrEnd = [];
    
    // 在数据中装入合法数据
    gradeArr.forEach(item => {
        gradeArrEnd.push(item.replace('=',':'));
    });

    const str = gradeArrEnd.join('\r\n');

    // 将数据写入到新的文件
    fs.writeFile('./files/grade-ok.txt',str,'utf8',function(err) {
        if (err) {
            return console.log('写入失败！');
        }
        return console.log('写入成功！');
    });
});