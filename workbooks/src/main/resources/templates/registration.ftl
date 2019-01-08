<#import  "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>

<@c.page>
<div class="mb-3">
    Добавить нового пользователя
</div>
<div class="text mb-2">
    ${message?ifExists}
</div>
<@l.login "/registration" true/>
</@c.page>