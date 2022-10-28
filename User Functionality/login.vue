<template>
  <div id="app">
    <form @submit.prevent="login">
      <input v-model="username" placeholder="username">User Name
      <input v-model="password" placeholder="password" type="password">Password
      <input type="submit" value="log in">
    </form>
  </div>
</template>
