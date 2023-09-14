$(document).ready(function () {
  
  $("#newProjectForm").submit(function (event) {
    event.preventDefault();

    
    $("#projectCreationModal").modal("show");
  });
});
