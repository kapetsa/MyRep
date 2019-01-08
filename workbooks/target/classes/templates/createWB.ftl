<#import  "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout/>
</div>
<div>
    <form method="post">
        <input type="text" class="form-control"
               value="<#if message??>${message}</#if>" name="name" placeholder="Название конспекта" />
          <#if nameError??>
                <div class="invalid-feedback">
                    ${nameError}
                </div>
          </#if>
        <input type="text" class="form-control"
               value="<#if message??>${message.spec}</#if>" name="spec" placeholder="Специальность">
          <#if specError??>
                <div class="invalid-feedback">
                    ${specError}
                </div>
          </#if>
        <input type="text" class="form-control"
               value="<#if message??>${message.name}</#if>" name="description" placeholder="Описание">
          <#if descriptionError??>
                <div class="invalid-feedback">
                    ${descriptionError}
                </div>
          </#if>
        <input type="text" class="form-control"
               value="<#if message??>${message.tag}</#if>"name="tag" placeholder="Тэг">
          <#if tagError??>
                <div class="invalid-feedback">
                    ${tagError}
                </div>
          </#if>
        <input type="text"  class="form-control"
               value="<#if message??>${message.body}</#if>" name="body" placeholder="Tекст">
          <#if bodyError??>
                <div class="invalid-feedback">
                    ${bodyError}
                </div>
          </#if>
        <button type="submit">Добавить</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>

</@c.page>