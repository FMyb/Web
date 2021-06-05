<template>
  <section>
    <div class="header">
      {{ post.title }}
    </div>
    <div class="body">
      {{ post.text }}
    </div>
    <div class="footer">
      <a href="#" @click.prevent="changePageToPostId(post.id)">View all</a>
    </div>
  </section>
</template>

<script>
export default {
  name: "SidebarPost",
  props: ["post"],
  methods: {
    changePageToPostId: function (id) {
      this.$root.$emit("onChangePageToPostId", id)
    }
  }
}
</script>

<style scoped>
section {
  margin-bottom: 1rem;
}
</style>