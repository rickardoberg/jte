package org.jusecase.jte.html;

import org.jusecase.jte.internal.StringUtils;

public class OwaspHtmlPolicy implements HtmlPolicy {
    @Override
    public void validateHtmlTag(HtmlTag htmlTag) throws HtmlPolicyException {
        if ( htmlTag.getName().contains("${") ) {
            throw new HtmlPolicyException("Illegal HTML tag name " + htmlTag.getName() + "! Expressions in HTML tag names are not allowed.");
        }
        if (StringUtils.containsUpperCase(htmlTag.getName())) {
            throw new HtmlPolicyException("HTML tags are expected to be lowercase.");
        }
    }

    @Override
    public void validateHtmlAttribute(HtmlTag htmlTag, HtmlAttribute htmlAttribute) throws HtmlPolicyException {
        if ( htmlAttribute.getName().contains("${") ) {
            throw new HtmlPolicyException("Illegal HTML attribute name " + htmlAttribute.getName() + "! Expressions in HTML attribute names are not allowed.");
        }
        if (htmlAttribute.getName().contains("@")) {
            throw new HtmlPolicyException("Illegal HTML attribute name " + htmlAttribute.getName() + "! Expressions in HTML attribute names are not allowed.");
        }
        if (!htmlAttribute.isBoolean() && htmlAttribute.getQuotes() != '\"' && htmlAttribute.getQuotes() != '\'') {
            throw new HtmlPolicyException("Unquoted HTML attribute values are not allowed.");
        }
        if (StringUtils.containsUpperCase(htmlAttribute.getName())) {
            throw new HtmlPolicyException("HTML attributes are expected to be lowercase.");
        }
    }
}
