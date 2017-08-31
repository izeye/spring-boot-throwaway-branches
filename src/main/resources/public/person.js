$(document).ready(function () {
  $.ajax({
    url: "http://localhost:18080/persons/1"
  }).then(function (data, status, jqxhr) {
    $('#id').append(data.id);
    $('#first_name').append(data.first_name);
    $('#last_name').append(data.last_name);
    $('#age').append(data.age);
    $('#created_time').append(data.created_time);
    console.log(status);
    console.log(jqxhr);
  });
});
