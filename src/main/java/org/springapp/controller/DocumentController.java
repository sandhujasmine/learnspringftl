/*
 * Basically used to mimick the AdminDocumentController within mifos. In mifos it is used to 
 * view, edit and update admin documents. 
 *   
 * This is used to implement, test, learn and get this mifos migration working before updating it in the
 * real application.
 */

package org.springapp.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("formBean")
public class DocumentController {

    // Using EditFundsController.java as an example
    private static final String REDIRECT_TO_ADMIN_SCREEN = "redirect:/AdminAction.do?method=load";
    private static final String REDIRECT_TO_VIEW_DOCS = "redirect:/editDocs.ftl";
    private static final String CANCEL_PARAM = "CANCEL";
    private static final String EDIT_PARAM = "EDIT";
    private static final String FORM_VIEW = "editDocs";

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/viewDocs", method = RequestMethod.GET)
    public ModelAndView showAllDocuments() {
    	ModelAndView modelAndView = new ModelAndView("viewDocs");
    	modelAndView.addObject("listofadministrativedocuments", createStub());
    	return modelAndView;
    }

    @RequestMapping(value = "/editDocs", method = RequestMethod.GET)
    public ModelAndView showDocument(HttpServletRequest request) {
    	Integer id = Integer.parseInt( request.getParameter("id"));
    	DocumentDto document = findByDocId( id);
    	
    	ModelAndView modelAndView = new ModelAndView( FORM_VIEW);
    
        /*
         * Form Backed Object - dummy data for testing
         */    
    	DocumentBean formBean = new DocumentBean();
    	formBean.setAccountType("loan");
    	formBean.setName( document.getName());
    	formBean.setId( document.getId());
    	//String[] statusEG = {"pendingApproval","appApproved"};
    	//formBean.setshowStatus( statusEG);
    
        // following maps used by spring macros formSingleSelect and formMultiSelect    
    	Map<String, String> accountType = accountTypeMap();
    	Map<String, String> showStatus = accountStatusMap(formBean.getAccountType());
    	
    	modelAndView.addObject("status", showStatus);
    	modelAndView.addObject("accountType", accountType);
    	modelAndView.addObject("formBean", formBean);
    	modelAndView.addObject("previewView", "docPreview");
    	
    	return modelAndView;
    }

	private Map<String, String> accountStatusMap(String accountType) {
		
		// hash map is used by view by spring macro formMultiSelect
		
		// used to populate UI listbox
		Map<String, String> showStatus = new LinkedHashMap<String, String>();
		showStatus.put("pendingApproval", messageSource.getMessage("manageReports.options.pendingApproval", null, null));
    	showStatus.put("appApproved", messageSource.getMessage("manageReports.options.appApproved", null, null));
    	
    	if (accountType.equals("loan")) {
    		showStatus.put("activeGoodStanding", messageSource.getMessage("manageReports.options.activeGoodStanding", null, null));
        	showStatus.put("activeBadStanding", messageSource.getMessage("manageReports.options.activeBadStanding", null, null));
        	showStatus.put("closedObligationMet", messageSource.getMessage("manageReports.options.closedObligationMet", null, null));
        	showStatus.put("closedWrittenOff", messageSource.getMessage("manageReports.options.closedWrittenOff", null, null));
        	showStatus.put("closedRescheduled", messageSource.getMessage("manageReports.options.closedRescheduled", null, null));
        	showStatus.put("custmrAccountActive", messageSource.getMessage("manageReports.options.custmrAccountActive", null, null));
        	showStatus.put("custmrAccountInactive", messageSource.getMessage("manageReports.options.custmrAccountInactive", null, null));
        	showStatus.put("cancel", messageSource.getMessage("manageReports.cancel", null, null));
    	} else {
    		// accountType can only be "loan" or "savings"
    		showStatus.put("active", messageSource.getMessage("manageReports.options.active", null, null));
    		showStatus.put("closed", messageSource.getMessage("manageReports.options.closed", null, null));
    		showStatus.put("inactive", messageSource.getMessage("manageReports.options.inactive", null, null));
    		showStatus.put("cancel", messageSource.getMessage("manageReports.cancel", null, null));
    	}
    	
    	return showStatus;
	}


	private Map<String, String> accountTypeMap() {

		// Linked list for use with spring macro formSingleSelect
    	Map<String, String> accountType = new LinkedHashMap<String, String>();

    	accountType.put("select", "-- Select --");
    	accountType.put("loan", messageSource.getMessage("manageReports.loanaccount", null, null));
    	accountType.put("savings", messageSource.getMessage("manageReports.savingsaccount", null, null));

		return accountType;
	}
    
    @RequestMapping( value = "/editDocs", method=RequestMethod.POST)
    public ModelAndView postDocument(@RequestParam(value = CANCEL_PARAM, required = false) String cancel,
            @RequestParam(value = "PREVIEWVIEW", required = true) String previewView,
            @ModelAttribute("formBean") DocumentBean formBean, BindingResult result, SessionStatus status) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_TO_VIEW_DOCS);

        if (StringUtils.isNotBlank(cancel)) {
            modelAndView.setViewName( REDIRECT_TO_VIEW_DOCS);
            status.setComplete();

        } else if (result.hasErrors()) {
            modelAndView.setViewName(FORM_VIEW);
            modelAndView.addObject( "previewView", formBean);

        } else {
		    modelAndView.setViewName(previewView); 
		    modelAndView.addObject("formBean", formBean);
        } 
		
		// TESTING
		System.out.println("Doc Name:" + formBean.getName());
		System.out.println("status:" + formBean.getshowStatus());
		
		return modelAndView;
	}


    // SEE IF WE CAN PUT THE CONTROLLER FOR ALL ADMIN FUNCTIONALITY IN HERE
    // WIP
    //@RequestMapping(value = "/docPreview", method = RequestMethod.POST)
    //public ModelAndView processFormSubmit(@RequestParam(value = EDIT_PARAM, required = false) String edit,
    //        @RequestParam(value = CANCEL_PARAM, required = false) String cancel, DocumentBean formBean,
    //        BindingResult result, SessionStatus status) {

    //    String viewName = REDIRECT_TO_ADMIN_SCREEN;
    //    ModelAndView modelAndView = new ModelAndView();
    //    if (StringUtils.isNotBlank(edit)) {
    //        viewName = "editDocs";
    //        modelAndView.setViewName(viewName);
    //        modelAndView.addObject("formBean", formBean);
    //        modelAndView.addObject("previewView", "fundPreview");
    //    } else if (StringUtils.isNotBlank(cancel)) {
    //        viewName = REDIRECT_TO_VIEW_DOCS;
    //        modelAndView.setViewName(viewName);
    //        status.setComplete();
    //    } else if (result.hasErrors()) {
    //        viewName = "docPreview";
    //        modelAndView.setViewName(viewName);
    //        modelAndView.addObject("formBean", formBean);
    //    } else {
    //        Integer id = formBean.getId();
    //        DocumentDto documentUpdate = findByDocId(id);
    //        
    //        // update object in persistent database using Service interface
    //        //this.adminDocumentServiceFacade.updateDocument(documentUpdate);    
    //        
    //        viewName = REDIRECT_TO_ADMIN_SCREEN;
    //        modelAndView.setViewName(viewName);
    //        status.setComplete();
    //    }
    //    return modelAndView;
    //}
    
    private DocumentDto findByDocId(Integer id) {
    	List<DocumentDto> docs = createStub();
    	return docs.get(id);
    }
    
    @SuppressWarnings("PMD")
    private List<DocumentDto> createStub(){
        List<DocumentDto> docs = new ArrayList<DocumentDto>();

        Integer[] docid = {0, 1, 2, 3};
        Boolean[] isactive = {true, false, true, false};
        String[] name = {"doc 1","doc 2","doc 3","doc 4"};
        String[] identifier   = {"id 1","id 2","id 3","id 4"};

        for (int i = 0; i < name.length; i++)
        {
            DocumentDto adminDoc = new DocumentDto(docid[i], name[i], identifier[i], isactive[i]);
            docs.add( i, adminDoc);
        }
        return docs;
    }
}
