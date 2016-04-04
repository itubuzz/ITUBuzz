<html>
	<script src="./js/jquery-1.12.2.min.js"></script>
    <script src="./js/jquery.tools.min.js"></script>
    <script src="./js/TextboxList.js"></script>
	<link rel="stylesheet" type="text/css" href="./css/overlay-apple.css">
	<link rel="stylesheet" type="text/css" href="./css/TextboxList.css">
	<!-- required stylesheet for TextboxList -->
	<link rel="stylesheet" href="./css/TextboxList.css" type="text/css" media="screen" charset=ISO-8859-1>
	<!-- required for TextboxList -->
	<script src="./js/GrowingInput.js" type="text/javascript" charset="utf-8"></script>
	<script src="./js/TextboxList.js" type="text/javascript" charset="utf-8"></script>		
	<!-- sample initialization -->
	<script type="text/javascript" charset="utf-8">		
		$(function(){
			// With custom adding keys 
			var t2 = $('#form_tags_input_2').textboxlist({bitsOptions:{editable:{addKeys: [188]}}});
		});
	</script>
	<style type="text/css" media="screen">
		.textboxlist { width: 400px; }
	</style>
	<script>
	$(document).ready(function() {
	  $("a[rel]").overlay({effect: 'apple'});
        });

	</script>
	<form action="createGroup" method="post">
	<a href="#" rel="#createGroupContainer">Create Group</a>
	<div class="apple_overlay" id="createGroupContainer">
		Create Group<br><br>
		<div>
			<table >
			<tr>
				<td align="right">Group Name: </td>
				<td><input type="text" name="group_name" value=""/><td>
			</tr>
			<tr>
				<td align="right">Members :    </td>
				<td>		<div class="form_tags"><input type="text" name="members" value="" id="form_tags_input_2" autocomplete="off" style="display: none;">
		</div></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="btnCreateGroup" value="Create Group"/></td>
			</tr>
			</table>
		</div>
	</div>
	</form>
</html>