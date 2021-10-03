document.addEventListener('DOMContentLoaded', function () {
    const elements = {
        codeSnippet: document.getElementById('code_snippet'),
        sendSnippetBtn: document.getElementById('send_snippet')
    }


    elements.sendSnippetBtn.onclick = function (e) {
        e.preventDefault();
        const code = {
            code: elements.codeSnippet.value
        }
        console.log(code);
        API.update(code, function () {
        })
        return false;
    }
})


