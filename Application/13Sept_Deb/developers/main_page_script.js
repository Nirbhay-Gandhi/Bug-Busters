// JavaScript for Main Page for Developers

// Simulated data (replace with actual data)
const developerName = "John Doe";
const userEmail = "developer@example.com";
const projectData = {
  projectName: "Sample Project",
  manager: "Project Manager Name",
  startDate: "2023-09-01",
  teamMembers: ["Team Member 1", "Team Member 2", "Team Member 3"],
};

// Update user information
document.querySelector(".user-info").innerHTML = `
    <h3>Welcome, ${developerName}</h3>
    <p>Email: ${userEmail}</p>
`;

// Update project information
document.querySelector(".project-info").innerHTML = `
    <h3>Project Details</h3>
    <label>Project Name:</label>
    <p>${projectData.projectName}</p>
    <label>Manager:</label>
    <p>${projectData.manager}</p>
    <label>Start Date:</label>
    <p>${projectData.startDate}</p>
    <label>Team Members:</label>
    <ul>
        ${projectData.teamMembers
          .map((member) => `<li>${member}</li>`)
          .join("")}
    </ul>
`;

// Display a message if the developer is not assigned to any project
if (projectData.teamMembers.length === 0) {
  document.querySelector(".message").style.display = "block";
} else {
  document.querySelector(".task-section").style.display = "block";
}
