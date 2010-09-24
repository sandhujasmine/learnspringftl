[#ftl] 	
[#import "spring.ftl" as spring]
[#--
* This is an example for displaying a stub of documents.
*
--]
[#assign loan][@spring.message "manageReports.loanaccount"/][/#assign]
[#assign savings][@spring.message "manageReports.savingsaccount"/][/#assign]

<head>
	<title>Form Example</title>
	<link rel="stylesheet" type="text/css" href="css/learnspringftl.css" />
</head>

<h1>Form Example</h1>
<form action="updateDoc.ftl" method = "POST">
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
	[@spring.bind "formBean.name" /]
	<label for="name"><span class="red">* </span>Document Name:</label> 
	<input id="name" type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" /><br>
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
	</li>
	
	<li>
	[@spring.bind "formBean.identifier" /]
	<label for="identity"><span class="red">* </span>Identifier:</label>
	<input id="identity" type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" /><br>
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
  	</li>
  	
  	[#-- 
  		Binding formBean.active to the radio buttons is not working correctly.
  	--]
  	<li>
  	[@spring.bind "formBean.active" /]
	<label for="active">Active: </label>
	[#if formBean.active]
		<input id="active" type="radio" name="${spring.status.expression}" checked />
	[#else]
		<input id="active" type="radio" name="${spring.status.expression}" />
	[/#if]
	</li>		
	<li>
	<label for="inactive">Inactive: </label>
	[#if formBean.active]
		<input id="inactive" type="radio" name="${spring.status.expression}" />
	[#else]
		<input id="inactive" type="radio" name="${spring.status.expression}" checked/>
	[/#if]
	
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
  	</li>
  	
  	<li>
	[@spring.bind "formBean.id" /]
	<label for="id"><span class="red">* </span>ID:</label>
	<input id="id" type="text" name="${spring.status.expression}" value="${spring.status.value?default("")}" /><br>
  	[#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
  	</li>  	
  	</ol>
</fieldset>
	
[#-- Submit data and invoke PostHelloForm.ftl --]
<fieldset class="submit">
	<input type="submit" value="Submit" />
</fieldset>
</form>	

	[#--
	<p>manageReports.documentinformation - [@spring.bind "formBean.name"/]
	<label name="${spring.status.expression}">${spring.status.value?default("")}</label>
	[@spring.showErrors "<br />"/]
	</p>
	
	<form name="" action="updateDoc.ftl" method="POST">
		<fieldset>
		<ol>
			<li>
			  <label for=formBean.name>[@spring.message "manageReports.administrativedocumenttitle"/]:</label>
			  [@spring.bind "formBean.name"/]
			  [@spring.formInput "formBean.name", '', ''/]
			  [#list spring.status.errorMessages as error] <b>${error}</b> <br> [/#list]
			</li>
			<li>
			  <label for=formBean.id>[@spring.message "manageReports.accounttype"/]:</label> 
			  [@spring.formSingleSelect "formBean.id", ["--select one--",loan,savings], ''/]
			</li>
			<li>
			  [@spring.message "manageReports.showwhenstatus"/]:
			  [@spring.formSingleSelect "formBean.identifier", ["--select one--",loan,savings], ''/]
			  <input type="submit" value="Submit" />
			</li>
		</ol>
		</fieldset>
	</form> --]
