[#ftl]
[#import "spring.ftl" as spring]

<head>
	<title>Post Form Input</title>
	<link rel="stylesheet" type="text/css" href="css/learnspringftl.css" />
</head>

<h1>Display Form Example Data</h1>

<form method="POST" action="docPreview.ftl" name="docPreview">
	<fieldset>
	<legend>[@spring.message "manageReports.documentinformation" /]</legend>
		<ol>
        <li>
        	[@spring.bind "formBean.name"/]
        	${spring.status.value?default("")}&nbsp;-&nbsp;[@spring.message "manageReports.viewAdminDocs.preview.previewDocumentInformation"/]<br>
        	[@spring.message "manageReports.viewAdminDocs.edit.previewTheFieldsBelow" /]
			[@spring.message "manageReports.viewAdminDocs.edit.ThenClickSubmit" /]
			[@spring.message "manageReports.viewAdminDocs.edit.ClickCancelToReturnToViewAdminDocsWithoutSubmittingInformation" /] 
		</li>
			
		<li>[@spring.message "manageReports.viewAdminDocs.preview.previewDocumentInformation"/]</li>
		
		<li>
		<label for="${spring.status.expression}">[@spring.message "manageReports.administrativedocumenttitle"/]</label>:&nbsp;&nbsp;[@spring.bind "formBean.name"/]
        ${spring.status.value?default("")} [@spring.showErrors "<br />"/]
		</li>
		
		<li>
		<label for="${spring.status.expression}">[@spring.message "manageReports.accounttype"/]</label>:&nbsp;&nbsp;[@spring.bind "formBean.accountType"/]
        ${spring.status.value?default("")}[@spring.showErrors "<br />"/]
        </li>
        
        <li>
        <label for="${spring.status.expression}">[@spring.message "manageReports.showwhenstatus" /]</label>:&nbsp;&nbsp;[@spring.bind "formBean.showStatus"/]
		${spring.status.value?default("")}[@spring.showErrors "<br />"/]
		[#list formBean.showStatus as value]
			<option value=${value?html}>${status[value]?html}</option><br>
	    [/#list]
        </li>
        
        <div class="clear">&nbsp;</div>
        [@spring.bind "formBean.name"/]<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
        [@spring.bind "formBean.accountType"/]<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
        [@spring.bind "formBean.showStatus"/]<input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
        <input type="submit" name="EDIT" value="[@spring.message "manageReports.viewAdminDocs.preview.editAdminDocInformation"/]"/>
        <div class="clear">&nbsp;</div>
		
		</ol>
	</fieldset>
	
	[#-- Submit data and invoke updateDoc.ftl --]
	<fieldset class="submit">
		<input type="submit" name="preview" value="[@spring.message "manageReports.preview" /]" />
		<input type="submit" id="CANCEL" name="CANCEL" value="[@spring.message "manageReports.cancel" /]" />
	</fieldset>	
</form>