

<nav class="navbar navbar-expand-lg navbar-dark bg-primary static-top" style="background-color: #3c8dbc !important;">
    <div class="container">
      <a class="navbar-brand" style="color:#fff !important">Quiz</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
        aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
        	<li class="nav-item ">
	            <a class="nav-link" href="topicVideo/topicVideoExcelImport">Import Topic Videos
	              <span class="sr-only">(current)</span>
	            </a>
          	</li>
          	<li class="nav-item">
            	<a class="nav-link" href="topicVideo/topicVideoList">Topic Video List</a>
          	</li>
          	<li class="nav-item">
            	<a class="nav-link" href="topicVideoQuestion/topicVideoQuestionsExcelImport">Import Topic Video Questions</a>
          	</li>
          	<li class="nav-item">
            	<a class="nav-link" href="topicVideoQuestion/topicVideoQuestionList">Topic Video Questions List</a>
          	</li>
          	
          	<li class="nav-item">
            	<a class="nav-link" href="logout">Logout</a>
          	</li>
        </ul>
      </div>
    </div>
  </nav>
  
  <script>
  
	$(".nav-link").each(function () {
    	var hrefa = $(this).attr('href');
		if(hrefa.includes("?")){
			var path=window.location.href;
      	 	var hrefa = $(this).attr('href');
			var hrefc = path.replace('${baseurl}','');
      		if (hrefc == hrefa) {
	        	$(this).parents('li').addClass('active ');
	        	return ;
			}
		} else{
      		var path=window.location.href;
      	 	var hrefa = $(this).attr('href');
			var hrefc = path.replace('${baseurl}','');
      		if (hrefc == hrefa) {
 	        	$(this).parents('li').addClass('active ');
 	        	return ;
      		}
		}
	});

  
  </script>