const http = require('http');

const server = http.createServer();

server.on('request',(req,res) => {
    const url = req.url;
    const method = req.method;
    res.setHeader('Content-Type','text/html;charset=UTF-8');

    const str = `请求地址是 ${url} ， 请求方式是 ${method}`;

    res.end(str);
});

server.listen(80,() => {
    console.log('server is on http://127.0.0.1');
});