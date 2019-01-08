<#macro login path isRegisterForm>
<form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"> Логин: </label>
        <div class="col-sm-6">
        <input type="text" name="username" class="form-control" placeholder="Логин"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"> Пароль: </label>
        <div class="col-sm-6">
        <input type="password" name="password" class="form-control" placeholder="Пароль"/>
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"> E-mail: </label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="Адрес электронной почты"/>
        </div>
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <button class="btn btn-primary mb-2" type="submit"><#if isRegisterForm>Зарегистрироваться<#else >Войти</#if></button>

    <div>
        <#if !isRegisterForm><a href="/registration">Зарегистрироваться</a></#if>
    </div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <button class="btn btn-primary mb-2" type="submit">Выйти</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>
</#macro>