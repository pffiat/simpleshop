<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@include file="/WEB-INF/jsp/init.jsp" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

This is the <b>simpleshop</b> portlet.<br />

<c:out escapeXml="true" value="${releaseInfo}" />.

<table class="table">
      <caption>Optional table caption.</caption>
      <thead>
        <tr>
          <th><liferay-ui:message key="title" /></th>
          <th><liferay-ui:message key="quantity" /></th>
          <th><liferay-ui:message key="price" /></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Mark</td>
          <td><aui:input name="quantity" label=""></aui:input></td>
          <td>@mdo</td>
        </tr>
      </tbody>
</table>
    