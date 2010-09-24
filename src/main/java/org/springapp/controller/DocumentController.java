/*
 * Basically used to mimick the AdminDocumentController within mifos. In mifos it is used to 
 * view, edit and update admin documents. 
 *   
 * This is used to implement, test, learn and get this mifos migration working before updating it in the
 * real application.
 */

package org.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DocumentController {

    @RequestMapping(value="/viewDocs", method = RequestMethod.GET)
    @ModelAttribute("listofadministrativedocuments")
    public List<DocumentDto> showAllDocuments() {
        return createStub();
    }

    @RequestMapping(value="/editDocs", method = RequestMethod.GET)
    @ModelAttribute("formBean")
    public DocumentBean showDocument(HttpServletRequest request) {
    	Integer id = Integer.parseInt( request.getParameter("id"));
    	DocumentDto document = findByDocId( id);
    	
    	/* TODO: Since the DocumentDto is an immutable object. We would like to have
    	*  a bean bound to the form that updates the document info. Basically don't want to 
    	*  chane the DocumentDto object. Work In Progress.
    	*/
    	DocumentBean documentBean = new DocumentBean( document.getId(), document.getName(), document.getIdentifier(), document.isActive());
    	return documentBean;
    }
    
    @RequestMapping(value="/updateDoc", method=RequestMethod.POST)
    public ModelAndView postDocument(@ModelAttribute DocumentBean formBean, BindingResult result) {
		
		if( result.hasErrors()) {
			System.out.println("BindingResult has errors!");
		} else {
			System.out.println("No BindingResult errors!");
		}
		// want to update the persistent data
		System.out.println("Doc Name:" + formBean.getName() +
				"Doc identifier:" + formBean.getIdentifier());
		
		ModelAndView mav = new ModelAndView("updateDoc");
		mav.addObject("userInputs", formBean);
		
		return mav;
	}
    
    private DocumentDto findByDocId(Integer id) {
    	List<DocumentDto> docs = createStub();
    	return docs.get(0);	// for now just return the 0th index
    }
    
    @SuppressWarnings("PMD")
    private List<DocumentDto> createStub(){
        List<DocumentDto> docs = new ArrayList<DocumentDto>();

        Integer[] docid = {1, 2, 3, 4};
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
