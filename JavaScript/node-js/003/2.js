const http = require('http');
const server = http.createServer();

server.on('request',(req,res) => {
    const url = req.url;
    let str = '<h1>404 NOT FOUND</h1>';
    console.log(url);

    if (url === '/' || url === '/index.html') {
        str = '<h1>首页</h1>'; 
    } else if (url === '/about.html') {
        str = '<h1>关于</h1>';
    }

    res.setHeader('Content-Type','text/html;charset=UTF-8');

    res.end(str);
});

server.listen(80,() => {
    console.log('server is on http://127.0.0.1');
});