<template>
  <footer>
    <a href="/">Codeforces</a> &copy; 2020 by Mike Mirzayanov<br/>
    Number of users: {{userCount}}<br/>
    Number of posts: {{postCount}}
  </footer>
</template>

<script>
export default {
  name: "Footer",
  props: ["userCount", "postCount"],
}
</script>

<style scoped>

</style>