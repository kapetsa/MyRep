<#import  "parts/common.ftl" as c>


<@c.page>

 <a href="/createWB">Добавить конспект</a>

<#list workbooks as workbook>

    <div class="card my-4" style="width: 60rem;">
        <div class="card-header">
            ${workbook.authorName}
        </div>
        <div class="card-body">
            <h5 class="card-title">${workbook.name}</h5>
            <p class="card-text">${workbook.description}</p>
            <a href="/book/${workbook.getId()}" class="btn btn-primary">Открыть конспект</a>
        </div>
    </div>
<#else >
<div>
Нет конспектов
</div>
</#list>


</@c.page>