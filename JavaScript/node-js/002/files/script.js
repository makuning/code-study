
        var input = window.document.querySelector('#input');
        var output = window.document.querySelector('#output');
        var btn = window.document.querySelector('#btn');

        btn.addEventListener('click',function(event) {
           output.value = input.value;
        });
    