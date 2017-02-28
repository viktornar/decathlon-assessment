<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <body style="font-family:Arial;font-size:12pt;background-color:#EEEEEE">
        <xsl:for-each select="competition/athlete">
            <div style="background-color:teal;color:white;padding:4px">
                <span style="font-weight:bold"><xsl:value-of select="fullName"/></span>
            </div>
            <br/>
            <xsl:for-each select="records/record">
                <div style="background-color:dimgray;color:white;padding:8px;display:inline">
                    <xsl:value-of select="."/>
                </div>
            </xsl:for-each>
            <div style="margin-bottom:1em;font-size:14pt;display:inline">
                <p>
                    Place: <xsl:value-of select="result/place"/> - Total score: <xsl:value-of select="result/score"/>
                </p>
            </div>
        </xsl:for-each>
    </body>
</html>