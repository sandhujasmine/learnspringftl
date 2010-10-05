[#ftl] 	
[#import "spring.ftl" as spring]
[#--
* This is an example for displaying a stub of documents.
*
--]

<head>
	<title>Form Example</title>
	<link rel="stylesheet" type="text/css" href="css/learnspringftl.css" />
</head>

<h1>Form Example</h1>
<form action="editDocs.ftl" method = "POST">
<fieldset>
<legend>[@spring.message "manageReports.documentinformation" /]</legend>
	<ol>
	<li>
		[@spring.message "manageReports.admindocumentdetails" /] 
	</li>
	<li> 
		[@spring.message "manageReports.completefieldsbelow" /] 
		[@spring.message "manageReports.clickcanceltoreturntoadmin" /]<br>
		<span class="red">* </span>[@spring.message "manageReports.requiredfieldsmarked" /]
	</li>
	
	<li>
	
	<input type="hidden" name="PREVIEWVIEW" id="previewview" value="${previewView}" />

	[#--
		Note: ${spring.status.expression}: expression used to retrieve bean/property
		In this case, it evaluates to name, so could've just used for="name" as well 
	--]
	[@spring.formInput "formBean.name", "maxlength=100", "text"/]
	<label for="${spring.status.expression}"><span class="red">* </span>[@spring.message "manageReports.administrativedocumenttitle" /]</label>
	</li>
	
	<li>
	[@spring.formSingleSelect "formBean.accountType", accountType /]
	<label for="${spring.status.expression}"><span class="red">* </span>[@spring.message "manageReports.accounttype" /]</label>
	</li>
	
	[#--
		Following is just a listbox display of the options based on whether the account
		type is loan or savings.
	--]
	<li>
	[@spring.bind "formBean.showStatus" /]
	<label for="statusMap"><span class="red">* </span>[@spring.message "manageReports.showwhenstatus" /]</label>
	<select multiple="multiple" size=6>
		[#list status?keys as value]
			<option value=${value?html}>${status[value]?html}</option><br>
	    [/#list]
	</select>	
	</li>
		
	[#--
		Following is a place holder for now - still need to figure out the spring implementation
		for file uploads.
	--]
	<li>
		<label for="file">[@spring.message "manageReports.selectadministrativedocument" /]</label>
		<input type="file" name="file" value="browse"/>
	</li>
		
  	</ol>
</fieldset>
	
[#-- Submit data and invoke updateDoc.ftl --]
<fieldset class="submit">
	<input type="submit" name="preview" value="[@spring.message "manageReports.preview" /]" />
	<input type="submit" id="CANCEL" name="CANCEL" value="[@spring.message "manageReports.cancel" /]" />
</fieldset>
</form>	