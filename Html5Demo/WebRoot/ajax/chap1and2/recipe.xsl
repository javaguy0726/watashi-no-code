<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" />

	<xsl:template match="/person">
		<div>
			<h5>
				<xsl:value-of select='@initial' />
				's favourite recipe was
				<xsl:value-of select='name' />
			</h5>
			<br />

			<xsl:apply-templates select="recipe/ingredient" />
			<p>
				<i>
					<xsl:value-of select='recipe/serving-suggestion' />
				</i>
			</p>
		</div>
	</xsl:template>

	<xsl:template match="ingredient">
		<table>
			<tr>
				<td>
					<xsl:value-of select='@qty' />
					:
					<xsl:value-of select='.' />
				</td>
			</tr>
		</table>
	</xsl:template>

</xsl:stylesheet>