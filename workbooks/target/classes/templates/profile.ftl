<#import "parts/common.ftl" as c>

<@c.page>
<h5>${username}</h5>
    ${message?ifExists}
<form method="post" xmlns="http://www.w3.org/1999/html">

    <div class="form-group row">
        <label class="col-sm-1 col-form-label"> Пароль: </label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Пароль"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-1 col-form-label"> E-mail: </label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="Адрес электронной почты" value="${email!''}"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <button class="btn btn-primary mb-2" type="submit">Сохранить изменения</button>



</@c.page>