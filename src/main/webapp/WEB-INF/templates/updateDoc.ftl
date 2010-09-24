[#ftl]
[#import "spring.ftl" as spring]

<head>
	<title>Post Form Input</title>
	<link rel="stylesheet" type="text/css" href="pages/css/learnspringftl.css" />
</head>

<h1>Display Form Example Data</h1>

<fieldset>
	<legend>User Inputs</legend>
	<ol>
	<li><label>Document Name:</label> ${userInputs.name}</li>
	<li><label>Identifier:</label> ${userInputs.identifier}</li> 
	<li><label>IsActive:</label>
		[#if userInputs.active ]
			True
		[#else]
			False
		[/#if]
	</li>
	<li><label>Object ID: </label>${userInputs.id}</li>
	</ol>
</fieldset>