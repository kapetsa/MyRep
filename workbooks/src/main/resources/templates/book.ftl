<#include "parts/security.ftl">
<#import  "parts/common.ftl" as c>


<@c.page>

 <div class="card my-4" style="width: 60rem;">
     <div class="card-header">
         ${author}
     </div>
     <div class="card-body">
         <h5 class="card-title">${bookname}</h5>
         <p class="card-text">${body}</p>
     </div>
 </div>


<form > <h5>Комментарии</h5>

<#list comments as comment>

    <div class="card my-4" style="width: 60rem;">
        <div class="card-header">
          ${comment.author}
        </div>
        <div class="card-body">
            <p class="card-text">${comment.text}</p>
        </div>

    </div>
<#else >
<div>
    Нет комментариев
</div>
</#list>
</form>
<form method="post">
    <input type="text" class="form-control"
               value="<#if message??>${message.text}</#if>" name="text" placeholder="Оставить комментарий...">
          <#if textError??>
                <div class="invalid-feedback">
                    ${textError}
                </div>
          </#if>
    <button type="submit">Добавить</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
</form>

</@c.page>

