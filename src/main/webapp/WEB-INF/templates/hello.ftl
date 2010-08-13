[#ftl]
[#include "layout.ftl"]

<!-- what is the span id attribute used for? -->
[@spring.messageText "admin", "testing .. "/]
[#--
[@adminLeftPaneLayout]
    <span id="page.id" title="view_question_details"></span>
	<div class="orangeheading marginTop15">
		[@spring.messageText "", "testing .. "/]
	</div>
[/@adminLeftPaneLayout]
--]
<pre>
Hello, World!

3 times 5 is ${3 * 5}

Bye...!
</pre>
