<#-- @ftlvariable name="codes" type="java.util.List<platform.api.model.CodeDto>" -->

<html lang="en">
<head>
    <title>${title!"Code"}</title>
    <link rel="stylesheet" href="/css/mini-default.min.css">
    <link rel="stylesheet" href="/css/default.min.css">
    <script src="/js/highlight.min.js"></script>
    <script>hljs.highlightAll();</script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list codes as code>
    <div class="row">
        <div class="col-sm-12 col-md-6">
            <p>
                <mark class="tertiary">
                    <span id="load_date">${code.date}</span>
                </mark>
            </p>
            <pre id="code_snippet">
                <code>${code.code}</code>
            </pre>
        </div>
    </div>

</#list>
</body>
</html>
