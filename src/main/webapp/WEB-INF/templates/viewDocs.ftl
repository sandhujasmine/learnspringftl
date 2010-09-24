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

<h1>
    [@spring.message "manageReports.viewadministrativedocuments"/]
</h1>
<p>
    [@spring.message "manageReports.belowislistofadministrativedocuments"/]
    [@spring.message "manageReports.toeditclickon"/]
    [@spring.message "manageReports.todownloadclickon"/]
    <a href="birtAdminDocumentUploadAction.do?method=getBirtAdminDocumentUploadPage&viewPath=administerreports_path">
    [@spring.message "manageReports.uploadanewadmindoc"/]</a>
</p>

<table width="75%" border="0" cellpadding="3" cellspacing="0" >
	[#list listofadministrativedocuments as adminDocument]
		<tr>
    		<td height="30" colspan="2" class="blueline">${adminDocument.name}</td>
    		<td width="45%"> 
				<a href="editDocs.ftl?id=${adminDocument.id}">
				[@spring.message "manageReports.edit"/]</a>
				|
				<a href="DocumentDownload.ftl?id=${adminDocument.id}">
				[@spring.message "manageReports.downloadadmindocuments" /]</a>
			</td>
		</tr>
	[/#list]
</table>
