
// Function to show the modal popup
function showBugSubmissionModal() {
  $("#bugSubmissionModal").modal("show");
}

// Function to hide the modal popup
function hideBugSubmissionModal() {
  $("#bugSubmissionModal").modal("hide");
}

// Function to perform form validation
function validateBugSubmissionForm() {
  var projectName = document.getElementById("projectName").value;
  var title = document.getElementById("title").value;
  var description = document.getElementById("description").value;
  var severity = document.getElementById("severity").value;

  if (
    projectName === "" ||
    title === "" ||
    description === "" ||
    severity === ""
  ) {
    alert("Please fill in all fields.");
    return false; // Prevent form submission
  }

  // If all validation checks pass, show the modal popup
  showBugSubmissionModal();

  // Prevent the form from actually submitting
  return false;
}

// Event listener for the submit button
document
  .getElementById("bugReportForm")
  .addEventListener("submit", function (e) {
    // Call the form validation function
    if (!validateBugSubmissionForm()) {
      e.preventDefault(); // Prevent form submission if validation fails
    }
  });

// Function to show the modal popup
function showBugSubmissionModal() {
    $('#bugSubmissionModal').modal('show');
}

// Function to hide the modal popup
function hideBugSubmissionModal() {
    $('#bugSubmissionModal').modal('hide');
}

// Function to perform form validation
function validateBugSubmissionForm() {
    var projectName = document.getElementById('projectName').value;
    var title = document.getElementById('title').value;
    var description = document.getElementById('description').value;
    var severity = document.getElementById('severity').value;

   
    if (projectName === '' || title === '' || description === '' || severity === '') {
        alert('Please fill in all fields.');
        return false; // Prevent form submission
    }

    // If all validation checks pass, show the modal popup
    showBugSubmissionModal();

    // Prevent the form from actually submitting
    return false;
}

// Event listener for the submit button
document.getElementById('bugReportForm').addEventListener('submit', function (e) {
    // Call the form validation function
    if (!validateBugSubmissionForm()) {
        e.preventDefault(); // Prevent form submission if validation fails
    }
});
