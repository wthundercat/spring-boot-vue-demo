<template>
<div class="form-control">
      <label>Name</label>
      <input type="text" v-model="firstName" name="firstName" placeholder="Enter Your Name" />
    </div>
    <div class="form-control">
      <label>Age</label>
      <input
        type="text"
        v-model="lastName"
        name="age"
        placeholder="Enter Your Age"
      />
    </div>
    <input type="submit" value="Save Information" class="btn btn-block" />
</template>

<script>
export default {
  name: 'Search',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
  }
}
</script>