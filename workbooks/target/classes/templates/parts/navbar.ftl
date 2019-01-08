<#include "security.ftl">
<#import  "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Все конспекты</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
            </#if>
        </ul>
    </div>

        <div class="navbar-text mr-3">
        <#if user?? &&  name??>
            Привет,${name}!
        <div>
            <a href="/user/profile">Мой профиль</a>
        </div>
        <#else>
        <a href="/login">Войти в аккаунт</a>
        </#if>
        <#if user?? &&  name??>
        <@l.logout/>
        </#if>
        </div>



</nav>